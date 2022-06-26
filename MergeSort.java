public class MergeSort implements Runnable{

    private VisualizerFrame frame;

	public void run() {
		Integer[] toBeSorted = SortingVisualizer.toBeSorted;
		inPlaceSort(toBeSorted);
		SortingVisualizer.isSorting=false;
	}


	public void inPlaceSort ( Integer[] x )
	   {  inPlaceSort (x, 0, x.length-1);
       }

   private void inPlaceSort ( Integer[] x, int first, int last )
   {
      int mid, lt, rt;
      int tmp;

      if ( first >= last )
          return;

      mid = (first + last) / 2;

      inPlaceSort (x, first, mid);
      inPlaceSort (x, mid+1, last);

      lt = first;
      rt = mid+1;


      if ( x[mid] <= x[rt])         //condition if already sorted
         return;

      while (lt <= mid && rt <= last)
      {

         if ( x[lt] <= x[rt])       //left select - no change
            lt++;
         else                       //right select - rotate
         {
            tmp = x[rt];     // move to lt
            for (int i = rt-lt;i>0; i--)
            {
            	x[lt+i] = x[lt+i-1];
            }
            x[lt] = tmp;

            lt++;
            mid++;
            rt++;    //moved everything up by one
         }

         SortingVisualizer.frame.reDrawArray(x, mid, rt, lt);
			try
            {
				Thread.sleep(SortingVisualizer.sleep);
			}
            catch (InterruptedException e)
            {
				e.printStackTrace();
			}
      }

   }



}


