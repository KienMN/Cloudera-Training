package stubs;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {

    /*
     * TODO implement
     */

	  int totalLength = 0;
	  int totalWords = 0;
	  
	  for (IntWritable value : values) {
		  totalLength += value.get();
		  totalWords += 1;
	  }
	  
	  double res = (totalLength * 1.0 / totalWords);
	  
	  context.write(key, new DoubleWritable(res));
	  
  }
}