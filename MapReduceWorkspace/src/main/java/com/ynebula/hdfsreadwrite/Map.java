package com.ynebula.hdfsreadwrite;

import org.apache.commons.logging.Log;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import org.apache.commons.logging.LogFactory;

public class Map extends Mapper<LongWritable, Text, NullWritable, Text> {
    private static final Log LOG = LogFactory.getLog(Map.class);
    private JobConf conf;
    private Text word = new Text();

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        //as your wish
        LOG.info("map input key : " + value.toString());

        String[] arr = value.toString().split("\t");

        if (!arr[3].equals("33") && !arr[3].equals("34")) {
            context.write(NullWritable.get(), new Text(value.toString()));
        }
    }
}
