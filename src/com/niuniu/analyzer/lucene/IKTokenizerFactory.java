package com.niuniu.analyzer.lucene;

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;

public class IKTokenizerFactory extends TokenizerFactory{
	
	boolean useSmart;
	
	@Override
  public void init(Map<String, String> args) {
    super.init(args);
    useSmart = Boolean.parseBoolean(args.get("useSmart"));
  }

	@Override
	public Tokenizer create(Reader in)
	{
        return new IKTokenizer(in, useSmart);
    }
}
