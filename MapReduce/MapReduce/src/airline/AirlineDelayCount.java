package airline;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;
 
import airline.DelayCountMapper;
import airline.DelayCountReducer;
 
public class AirlineDelayCount {
 
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
 
        Configuration conf = new Configuration();
         
        // ����� ������ ��� Ȯ��
        if(args.length != 2){
            System.out.println("Usage : AirlineDelayCount <input> <output>");
            System.exit(2);
        }
         
        // �� �̸� ����
        Job job = new Job(conf, "AirlineDelayCount");
         
        // ����� ������ ��� ����
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
         
        // �� Ŭ���� ����
        job.setJarByClass(AirlineDelayCount.class);
         
        // ���� Ŭ���� ����
        job.setMapperClass(DelayCountMapper.class);
         
        // ���༭ Ŭ���� ����
        job.setReducerClass(DelayCountReducer.class);
//      job.setReducerClass(IntSumReducer.class);
         
        // ����� ������ ���� ����
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
         
        // ��� Ű �� ��°� ���� ����
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
         
        job.waitForCompletion(true);   
    }
}