package com.sample.test.flipkart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class FlipkartService {

	// public static Set<Product> productSet = new HashSet<>();

	//sellerId->feedList
	private static Map<String, ConcurrentSkipListSet<Product>> sellerProductsSet = new Hashtable<String, ConcurrentSkipListSet<Product>>();
//	private static List<Feed> feedList = new ArrayList<>();
	private static Map<String, Map<String, ConcurrentSkipListSet<Product>>> custSellerProductMapper = new HashMap<>();
	
	public static Map<String, ConcurrentSkipListSet<Product>> getSellerProductsSet() {
		return sellerProductsSet;
	}

	public static void setSellerProductsSet(Map<String, ConcurrentSkipListSet<Product>> sellerProductsSet) {
		FlipkartService.sellerProductsSet = sellerProductsSet;
	}

	public static Map<String, Map<String, ConcurrentSkipListSet<Product>>> getCustSellerProductMapper() {
		return custSellerProductMapper;
	}

	public static void setCustSellerProductMapper(Map<String, Map<String, ConcurrentSkipListSet<Product>>> custSellerProductMapper) {
		FlipkartService.custSellerProductMapper = custSellerProductMapper;
	}

//	public static List<Feed> getFeedList() {
//		return feedList;
//	}
//
//	public static void setFeedList(List<Feed> feedList) {
//		SellerService.feedList = feedList;
//	}


}
