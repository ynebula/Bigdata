package airline;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
 
public class DelayCountReducer extends Reducer<Text, Iterable<IntWritable>, Text, IntWritable>{
 
    private IntWritable result = new IntWritable();
     
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException{
        int sum = 0;
         
        for(IntWritable value : values){
            sum += value.get();
            System.out.println(key.toString() + " : " + sum);
        }
         
        result.set(sum);
        context.write(key, result);
    }
}