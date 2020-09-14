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
         
        // 입출력 데이터 경로 확인
        if(args.length != 2){
            System.out.println("Usage : AirlineDelayCount <input> <output>");
            System.exit(2);
        }
         
        // 잡 이름 설정
        Job job = new Job(conf, "AirlineDelayCount");
         
        // 입출력 데이터 경로 설정
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
         
        // 잡 클래스 설정
        job.setJarByClass(AirlineDelayCount.class);
         
        // 매퍼 클래스 설정
        job.setMapperClass(DelayCountMapper.class);
         
        // 리듀서 클래스 설정
        job.setReducerClass(DelayCountReducer.class);
//      job.setReducerClass(IntSumReducer.class);
         
        // 입출력 데이터 포멧 설정
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
         
        // 출력 키 및 출력값 유형 설정
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
         
        job.waitForCompletion(true);   
    }
}