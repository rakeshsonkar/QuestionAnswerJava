package june.programming.interview.questions;

public class BinarySearchMain {
	public static void main(String[] args) {
		
	}
	
	public static int binarySearch(int arr[],int low,int high,int key) {
			int mid = (low+high)/2;

			while(low <= high) {
				if(arr[mid] < key){
					low = mid + 1;
				} else if(arr[mid]==key) {
					return mid;
				}else {
					
				}
			}
		return -1;
	}
}
