
class Interval  {
	int start;
	int end;
	public Interval(){
		start=0;
		end=0;
		
	}
	Interval(int s,int e){
		start=s;
		end=e;
	}

	
}

//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

public class merInterval {

/*
*  题目；https://leetcode.com/problems/merge-intervals/description/
* 先根据区间左边界大小升序排列，然后向右合并
*/
	public static List<Interval> merge(List<Interval> intervals){
		if(intervals==null||intervals.size()==0)
			return intervals;
		//利用list集合 Comparator进行排序(升序排列)
		Collections.sort(intervals,new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		
		int size=intervals.size();
		int i=0,index=0;
		////判断i和i+1元素空间是否有交叉
		while(i<size){
			index= i+1;
			if(index<size){
				//i元素空间是否包含了i+1元素空间
				if(intervals.get(i).end>=intervals.get(index).end){
					intervals.remove(index);
					size=size-1;
				}
				//i和i+1是否部分空间重叠
				else if(intervals.get(i).end>=intervals.get(index).start){
					intervals.get(i).end=intervals.get(index).end;
					intervals.remove(index);
					size=size-1;
				}
				else{
					i++;
				}
			}	
			else break;
		}
		return intervals;
	}

}
