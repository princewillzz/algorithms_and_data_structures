import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Job {
    public char id;
    public int deadline;
    public int profit;
    Job(char a, int b, int c) {
        id = a;
        deadline = b;
        profit = c;
    }
}
class CompareJobs implements Comparator<Job> {
    
    public int compare(Job o1, Job o2) {
        
        return o1.profit > o2.profit? -1: 1;
    }
} 

public class JobScheduling{

        public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Job jobs[] =  new Job[]{new Job('a', 2, 100), new Job('b', 1, 19), new Job('c', 2, 27), new Job('d', 1, 25), new Job('e', 3, 15)};
        
        solve(jobs);
        
    }
    static void solve(Job jobs[]) {
        Arrays.sort(jobs, new CompareJobs());int maxTime = 0;
        for(int i = 0; i < jobs.length; i++) maxTime = Math.max(jobs[i].deadline, maxTime);
        char ans[] = new char[maxTime];int sum = 0;

        for(int i = 0; i < jobs.length; i++) {

            Job j = jobs[i];
            int x = j.deadline;
            while(x-- > 0) {
                if(ans[x] < 'a' || ans[x] > 'z') {
                    ans[x] = j.id;
                    sum += j.profit;
                    break;
                }
                
            }

        }
        for(char i: ans) System.out.print(i + " ");
        System.out.println("\nProfit: " + sum);
        //for(Job j: jobs) System.out.println(j.id + " " + j.deadline + " "+ j.profit);
    }

}