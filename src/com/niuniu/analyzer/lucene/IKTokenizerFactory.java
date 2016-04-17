package com.niuniu.analyzer.lucene;

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;

public class IKTokenizerFactory extends TokenizerFactory{
	
	boolean useSmart;
	int useMerge;
	int mergeSize;
	
	@Override
  public void init(Map<String, String> args) {
    super.init(args);
    
    String smart = args.get("useSmart");
    useSmart = (smart != null ?Boolean.parseBoolean(smart) : IKTokenizer.DEFAULT_USESMART);
    
    String um = args.get("useMerge");
    useMerge = (um != null ? Integer.parseInt(um) : IKTokenizer.DEFAULT_USEMERGE);
    
    String ms = args.get("mergeSize");
    mergeSize = (ms != null ? Integer.parseInt(ms) : IKTokenizer.DEFAULT_MERGESIZE);
  }

	@Override
	public Tokenizer create(Reader in)
	{
        return new IKTokenizer(in, useSmart, useMerge, mergeSize);
    }
}
