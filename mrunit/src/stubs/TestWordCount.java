package stubs;

import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class TestWordCount {

  /*
   * Declare harnesses that let you test a mapper, a reducer, and
   * a mapper and a reducer working together.
   */
  MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
  ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
  MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

  /*
   * Set up the test. This method will be called before every test.
   */
  @Before
  public void setUp() {

    /*
     * Set up the mapper test harness.
     */
    WordMapper mapper = new WordMapper();
    mapDriver = new MapDriver<LongWritable, Text, Text, IntWritable>();
    mapDriver.setMapper(mapper);

    /*
     * Set up the reducer test harness.
     */
    SumReducer reducer = new SumReducer();
    reduceDriver = new ReduceDriver<Text, IntWritable, Text, IntWritable>();
    reduceDriver.setReducer(reducer);

    /*
     * Set up the mapper/reducer test harness.
     */
    mapReduceDriver = new MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable>();
    mapReduceDriver.setMapper(mapper);
    mapReduceDriver.setReducer(reducer);
  }

  /*
   * Test the mapper.
   */
  @Test
  public void testMapper() {

    /*
     * For this test, the mapper's input will be "1 cat cat dog" 
     * TODO: implement
     */
    //fail("Please implement test.");
	  mapDriver.withInput(new LongWritable(0), new Text("cat dog"));
	  mapDriver.withOutput(new Text("cat"), new IntWritable(1));
	  mapDriver.withOutput(new Text("dog"), new IntWritable(1));
	  mapDriver.runTest();

  }

  /*
   * Test the reducer.
   */
  @Test
  public void testReducer() {

    /*
     * For this test, the reducer's input will be "cat 1 1".
     * The expected output is "cat 2".
     * TODO: implement
     */
    //fail("Please implement test.");
	  reduceDriver.withInput(new Text("cat"), Arrays.asList(new IntWritable(1), new IntWritable(1)));
	  reduceDriver.withOutput(new Text("cat"), new IntWritable(2));
	  reduceDriver.runTest();
  }


  /*
   * Test the mapper and reducer working together.
   */
  @Test
  public void testMapReduce() {

    /*
     * For this test, the mapper's input will be "1 cat cat dog" 
     * The expected output (from the reducer) is "cat 2", "dog 1". 
     * TODO: implement
     */
    //fail("Please implement test.");
	  mapReduceDriver.withInput(new LongWritable(0), new Text("dog cat"));
	  mapReduceDriver.withInput(new LongWritable(0), new Text("cat dog"));
	  mapReduceDriver.withOutput(new Text("cat"), new IntWritable(2));
	  mapReduceDriver.withOutput(new Text("dog"), new IntWritable(2));
	  mapReduceDriver.runTest();
  }
}
