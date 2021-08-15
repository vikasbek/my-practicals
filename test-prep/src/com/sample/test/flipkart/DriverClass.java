package com.sample.test.flipkart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
interface ABC{
//	int intval();
//	static {}
	default void sum(){}
}

abstract class XYZ{
	
	XYZ(){
		System.out.println("In XYZ constructor");
	}
	
	static {
		System.out.println("In XYZ static");
	}
	
	static final int a=1;
	
}

class Pqr extends XYZ implements ABC{
	static {
		System.out.println("In Pqr static");
	}
	Pqr(){
		System.out.println("In pqr constructor");
	}
}
public class DriverClass {
	public static List<Seller> sellerList = new ArrayList<>();
	public static List<Customer> customerList = new ArrayList<>();

	public static void main(String[] args) {
		boolean start = true;
		XYZ abc= new Pqr();
		
		while (start) {
			boolean retry = true;
			int caseInt = 0;
			while (retry) {
				System.out.println("Enter 1 to create seller.");
				System.out.println("Enter 2 create customer.");
				System.out.println("Enter 3 select seller.");
				System.out.println("Enter 4 select customer.");
				System.out.println("Enter 5 to exit system.");
				System.out.println("Seller:" + sellerList);
				System.out.println("Customer:" + customerList);
				Scanner sc = new Scanner(System.in);
				String caseType = sc.nextLine();
				try {
					caseInt = Integer.parseInt(caseType);
					retry = false;
				} catch (NumberFormatException ex) {
					retry = true;
				}
			}
			Scanner sc = new Scanner(System.in);
			switch (caseInt) {
				case 1:
					boolean createSeller = true;
					while (createSeller) {
						System.out.println("Please enter seller name");
						String sellerName = sc.nextLine();
						System.out.println("Please enter seller rating(1-5)");
						String sellerRatingString = sc.nextLine();
						int sellerRatingInt = 0;
						try {
							sellerRatingInt = Integer.parseInt(sellerRatingString);
							createSeller = false;
						} catch (NumberFormatException ex) {
							createSeller = true;
							System.out.println("Invalid Rating.");
						}
						Seller seller = new Seller(sellerName, sellerRatingInt);
						sellerList.add(seller);
						FlipkartService.getSellerProductsSet().put(seller.getSellerId().toString(), new ConcurrentSkipListSet<>());
						System.out.println("seller created successful");
					}
					break;
				case 2:
					boolean createUser = true;
					while (createUser) {
						System.out.println("Please enter customer name");
						String customerName = sc.nextLine();
						Customer seller = new Customer(customerName);
						customerList.add(seller);
						System.out.println("customer created successful");
						createUser = false;
					}
					break;
				case 3:
					String sellerId = sc.nextLine();
					System.out.println("publish post for sellerId : " + sellerId);
					boolean allowOperation = true;
					while (allowOperation) {
						System.out.println("Enter 1 to publish post");
						System.out.println("Enter 2 to delete post");
						System.out.println("Enter 3 to delete post");
						System.out.println("Enter any key to exit");
						String opt = sc.nextLine();
						switch (opt) {
							case "1":
								publishPost(sc, sellerId);
								break;
							case "2":
								deletePost(sc, sellerId);
								break;
							case "3":
								allowOperation = false;
								break;
							default:
								allowOperation = false;
								break;
						}
					}
					break;
				case 4:
					customerSelectionOperation(sc);
					break;
				case 5:
					start = false;
					break;
				default:
					System.out.println("Invalid input retry");

			}
		}
	}

	private static void deletePost(Scanner sc, String sellerId) {
		System.out.println("Enter product name");
		String postName = sc.next();
		Set<Product> productList = FlipkartService.getSellerProductsSet().get(sellerId);
		Iterator<Product> itr = productList.iterator();
		while (itr.hasNext()) {
			Product p = itr.next();
			if (p.getProductName().equals(postName)) {
				itr.remove();
			}
		}
	}

	private static void publishPost(Scanner sc, String sellerId) {
		boolean publishPost = true;

		while (publishPost) {
			try {
				System.out.println("enter product name");
				String productName = sc.nextLine();
				System.out.println("enter product price");
				String price = sc.nextLine();
				System.out.println("enter product category");
				String category = sc.nextLine();
				Product product = new Product(productName, Double.valueOf(price), category);
				if (FlipkartService.getSellerProductsSet().containsKey(sellerId)) {
					ConcurrentSkipListSet<Product> feed = FlipkartService.getSellerProductsSet().get(sellerId); 
					feed.add(product);
					FlipkartService.getSellerProductsSet().get(sellerId).add(product);
				} else {
					ConcurrentSkipListSet<Product> productList = new ConcurrentSkipListSet<>() ;
					FlipkartService.getSellerProductsSet().put(sellerId, productList);
				}
				// SellerService.getFeedList().add(new Feed(sellerId, product));
				// SellerService.feeds.add(e)
				System.out.println("enter 1 to add more post or press any key");
				String t = sc.nextLine();
				if (t.equals("1")) {
					publishPost = true;
				} else {
					publishPost = false;
				}
			} catch (Exception ex) {
				System.out.println(ex);
				publishPost = false;
			}
		}
	}

	private static void customerSelectionOperation(Scanner sc) {
		String customerId = sc.nextLine();
		System.out.println("selected customer" + customerId);
		System.out.println("Existing seller are " + sellerList);
		boolean allowOperation = true;
		while (allowOperation) {
			System.out.println("Enter 1 to subscribe");
			System.out.println("Enter 2 to unsubscribe");
			System.out.println("Enter 3 to fetch feeds based on recency of post");
			System.out.println("Enter 4 to fetch feeds based on seller rating");

			String selectedOption = sc.nextLine();
			switch (selectedOption) {
				case "1":
					subscribeMerchant(customerId);
					break;
				case "2":
					 unsubscribeMerchant(customerId);
					break;
				case "3":
					fetchPostsOfSubscribedMerchant(customerId);
					break;
				case "4":
					// fetchPostsBasedOnRating();
					break;
				case "5":
					break;
				default:
					break;
			}
			System.out.println("enter 1 to do again or press any key");
			if (sc.nextLine().equals("1")) {
				allowOperation = true;
			} else {
				allowOperation = false;
			}
		}
	}

	private static void unsubscribeMerchant(String custId) {
		System.out.println("Please select sellerId from below sellers.");
		System.out.println(sellerList);
		String sellerId = new Scanner(System.in).nextLine();
		System.out.println("selected sellerId: " + sellerId);
		if (FlipkartService.getCustSellerProductMapper().containsKey(custId)) {
			FlipkartService.getCustSellerProductMapper().get(custId).remove(sellerId);
		}
		System.out.println("unsubscribed");
	}

	final int a;
	public DriverClass() {
	 this.a = 1;
	}
	private static void fetchPostsOfSubscribedMerchant(String custId) {
		Map<String, ConcurrentSkipListSet<Product>> subscribedSellerList = FlipkartService.getCustSellerProductMapper().get(custId);
		subscribedSellerList.forEach((k,v)->{
			v.forEach((p)->{
				System.out.println(p.toString());
			});
		});
	}

	private static void subscribeMerchant(String custId) {
		System.out.println("Please select sellerId from below sellers.");
		System.out.println(sellerList);
		String sellerId = new Scanner(System.in).nextLine();
		System.out.println("selected sellerId: " + sellerId);
		try {
			Class<?> p = Product.class.forName("Product");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (FlipkartService.getCustSellerProductMapper().containsKey(custId)) {
			FlipkartService.getCustSellerProductMapper().get(custId).put(sellerId, FlipkartService.getSellerProductsSet().get(sellerId));
		} else {
			Map<String, ConcurrentSkipListSet<Product>> productSellerMap = new HashMap<>();
			productSellerMap.put(sellerId, FlipkartService.getSellerProductsSet().get(sellerId));
			FlipkartService.getCustSellerProductMapper().put(custId, productSellerMap);
		}
	}
}
