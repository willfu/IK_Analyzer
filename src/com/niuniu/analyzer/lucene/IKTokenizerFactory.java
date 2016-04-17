package com.niuniu.analyzer.lucene;

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;

public class IKTokenizerFactory extends TokenizerFactory{
	
	boolean useSmart;
	boolean separate;
	int sepMinCount;
	
	@Override
  public void init(Map<String, String> args) {
    super.init(args);
    useSmart = Boolean.parseBoolean(args.get("useSmart"));
    separate = Boolean.parseBoolean(args.get("separate"));
    sepMinCount = Integer.parseInt(args.get("sepMinCount"));
  }

	@Override
	public Tokenizer create(Reader in)
	{
        return new IKTokenizer(in, useSmart, separate, sepMinCount);
    }
}
