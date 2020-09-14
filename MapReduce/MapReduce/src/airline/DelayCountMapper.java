package airline;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import airline.AirlinePerformanceParser;
 
public class DelayCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
 
    // 맵 출력 값
    private final static IntWritable outputValue = new IntWritable(1);
     
    // 맵 출력 키
    private Text outputKey = new Text();
     
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        AirlinePerformanceParser parser = new AirlinePerformanceParser(value);
         
        // 출력키 설정
        outputKey.set(parser.getYear() + "," + parser.getMonth());
         
        if (parser.getDepartureDelayTime() > 0) {
            // 출력 데이터 생성
            context.write(outputKey, outputValue);
        }
    }
}