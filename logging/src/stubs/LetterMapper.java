package stubs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

public class LetterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private boolean caseSensitive;
	private static final Logger LOGGER = Logger.getLogger(LetterMapper.class.getName());

	@Override
	protected void setup(Context context) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		Configuration conf = context.getConfiguration();
		caseSensitive = conf.getBoolean("caseSensitive", false);
	}

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		/*
		 * TODO implement
		 */
		if (caseSensitive) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Case sensitive is enabled");
			}
			String line = value.toString();
			for (String word : line.split("\\W+")) {
				if (word.length() > 0) {
					context.write(new Text(word.substring(0, 1)),
							new IntWritable(word.length()));
				}
			}
		} else {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Case sensitive is disabled");
			}
			String line = value.toString();
			for (String word : line.split("\\W+")) {
				if (word.length() > 0) {
					context.write(new Text(word.substring(0, 1).toLowerCase()),
							new IntWritable(word.length()));
				}
			}
		}
	}
}
