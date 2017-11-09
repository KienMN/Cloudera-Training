package stubs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Example input line: 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400]
 * "GET /cat.jpg HTTP/1.1" 200 12433
 * 
 */
public class ImageCounterMapper extends
		Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		/*
		 * TODO implement
		 */
		String line = value.toString();
		if (line.toLowerCase().contains(".gif")) {
			context.getCounter("ImageCounter", "gif").increment(1);
			context.write(new Text("gif"), new IntWritable(1));
		} else if (line.toLowerCase().contains(".jpeg")) {
			context.getCounter("ImageCounter", "jpeg").increment(1);
			context.write(new Text("jpeg"), new IntWritable(1));
		} else {
			context.getCounter("ImageCounter", "other").increment(1);
			context.write(new Text("other"), new IntWritable(1));
		}
		
	}
}