package pageFile;

import helperFile.base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class fanCodeCityPage {

    static ArrayList<Integer> numberOfFanCodeUser;
    static Response todoTaskResp;

    /**
     * below method is for fetching all task
     */

    public void userHasToDoTask(){
        RestAssured.baseURI="http://jsonplaceholder.typicode.com/";
        todoTaskResp= given().log().all().when().get("todos").then().assertThat().statusCode(200)
                .extract().response();
    }

    /**
     * below code is to filter the Fancode city user
     */
    public void userBelongsToCityFanCode(){

        Response onlyFanCodeCityResp= given().log().all().when().get("users").then().assertThat()
                .statusCode(200).extract().response();


        String strfancodecity=onlyFanCodeCityResp.asPrettyString();
        JsonPath js= new JsonPath(strfancodecity);
        int size=Integer.parseInt(js.getString("size()"));
        numberOfFanCodeUser=new ArrayList<Integer>();
        for (int i=0;i<size;i++){
            String pathLat="["+i+"].address.geo.lat";
            String pathLng="["+i+"].address.geo.lng";
            double valueLat= js.getFloat(pathLat);
            double valueLng= js.getFloat(pathLng);
            boolean conditon= ((valueLat>-40)&&(valueLat<5))&&(valueLng>5&&valueLng<100);
            if (conditon){
                numberOfFanCodeUser.add(i+1);
            }
        }
    }

    /**
     * below code is to check weather the fancode city user has more than completed task
     * @param requiredPrecent
     */
    public void userCompletedTaskShouldBeGreaterThanRequiredPercent(int requiredPrecent){
        String strTodoTask = todoTaskResp.asPrettyString();
        JsonPath js = new JsonPath(strTodoTask);
        int size = js.getInt("size()");

        double completedCount = 0;
        double total = 0;

        for (int index = 0; index < size; index++) {
            int userId = js.getInt("[" + index + "].userId");
            boolean isCompleted = js.getBoolean("[" + index + "].completed");

            if (numberOfFanCodeUser.contains(userId)) {
                total++;
                if (isCompleted) {
                    completedCount++;
                }
            }
        }

        double completedPrecentage=(completedCount/total)*100;
        Assert.assertTrue("task completed percent is not greater than "+requiredPrecent ,completedPrecentage>requiredPrecent);
    }

}
