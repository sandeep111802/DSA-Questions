class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int h = height.length-1;

        int maxWater =0;

        while(l<h){
            int width = h-l;
            int height1 = Math.min(height[l],height[h]);

            int area = width*height1;

            if(height[l]<height[h]){
                l++;
            }else{
                h--;
            }

            maxWater = Math.max(area,maxWater);

        }

        return maxWater;
    }
}