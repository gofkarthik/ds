package ds_ref.greedyAlgorithms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelectionMain {

	public static List<Activity> activities(List<Activity> activities){
	  List<Activity> actList= new ArrayList<>();
		Collections.sort(activities,
				(a1,a2)->a1.getFinishTime()-a2.getFinishTime());
		Activity activity1=activities.get(0);
		actList.add(activity1);
		for(int i=1;i<activities.size();i++){
			Activity activity2=activities.get(i);
			if(activity2.getStartTime() >= activity1.getFinishTime()){
				actList.add(activity2);
				activity1=activity2;
			}
		}
		return actList;
	}

	public static void main(String[] args) {
		//Create an ArrayList to store all activities
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		
		//Insert activities in Arraylist
		activityList.add(new Activity("A1", 0, 6));
		activityList.add(new Activity("A2", 3, 4));
		activityList.add(new Activity("A3", 1, 2));
		activityList.add(new Activity("A4", 5, 8));
		activityList.add(new Activity("A5", 5, 7));
		activityList.add(new Activity("A6", 8, 9));
	
		//Print user entered data
		System.out.println("User provided Schedule:");
		for (int i = 0; i < activityList.size() ; i++) {
			Activity activity = activityList.get(i);
			System.out.println(activity.toString());
		}
		
		//Perform calculation on activities
		ActivitiySelection.activitySelection(activityList);
		System.out.println("new result");
		List<Activity> activitiesRes = activities(activityList);
		for (Activity activity : activitiesRes) {
			System.out.println(activity);
		}
	}//end of method
}//end of class