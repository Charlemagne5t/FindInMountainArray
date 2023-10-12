public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int left = 0;
        int right = length - 1;
        int mid = left + (right - left) / 2;
        int peak = -1;
        while (left <= right){
            mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            int preMidValue = mountainArr.get(mid - 1);
            int postMidValue = mountainArr.get(mid + 1);

            if(preMidValue < midValue && postMidValue < midValue){
                peak = mid;
                break;
            }
            if(preMidValue < midValue && postMidValue > midValue){
                left = mid;
            }
            if(preMidValue > midValue && postMidValue < midValue){
                right = mid;
            }
        }
        int searchASC = binarySearchASC(target, mountainArr, peak);
        if(searchASC != -1){
            return searchASC;
        }
        int searchDESC = binarySearchDESC(target, mountainArr, peak + 1, length);
        if(searchDESC != -1){
            return searchDESC;
        }


        return -1;
    }
    public int binarySearchASC(int target, MountainArray mountainArr, int right){
        int left = 0;
        int mid = left + (right - left) / 2;

        while (left <= right){
            mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }
            if(target < midVal){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchDESC(int target, MountainArray mountainArr, int left, int length){
        int right = length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right){
            mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }
            if(target > midVal){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
