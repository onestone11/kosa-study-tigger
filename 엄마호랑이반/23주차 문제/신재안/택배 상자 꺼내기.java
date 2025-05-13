class Solution {
    public int solution(int n, int w, int num) {
        int targetRow = (num - 1) / w;
        int posInRow = (num - 1) % w;
        boolean isTargetRowEven = (targetRow % 2 == 0);
        int targetCol = isTargetRowEven ? posInRow : w - 1 - posInRow;

        int lastLayerRow = (n - 1) / w;
        int lastLayerSize = (n % w == 0) ? w : n % w;
        int upperLayerCount = lastLayerRow - targetRow;

        boolean hasBoxInLastLayer = false;
        if (upperLayerCount > 0) {
            boolean isLastLayerEven = (lastLayerRow % 2 == 0);
            hasBoxInLastLayer = isLastLayerEven 
                ? targetCol < lastLayerSize 
                : targetCol >= w - lastLayerSize;
        }

        int boxAbove = upperLayerCount > 0
            ? upperLayerCount - (hasBoxInLastLayer ? 0 : 1)
            : 0;

        return boxAbove + 1;
    }
}
