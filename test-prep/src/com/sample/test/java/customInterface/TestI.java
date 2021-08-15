package com.sample.test.java.customInterface;

import java.util.HashMap;
import java.util.Map;

public interface TestI {

	public static final String DYNAMIC_QR_CODE = "DYNAMIC_QR_CODE";

	public static final String MERCHANT_QR_CODE = "MERCHANT_QR_CODE";

	public static final String QR_ORDER = "QR_ORDER";

	public static final String QR_PRODUCT = "QR_PRODUCT";

	public static final String USER_QR_CODE = "USER_QR_CODE";

	public static final String GENERATE_QR_IMG = "GENERATE_QR_IMG";

	public static final String QR_CODE_DEEPLINK = "QR_CODE_DEEPLINK";

	public static final String QR_PRICEDPRODUCT = "QR_PRICEDPRODUCT";

	public static final String UTS = "UTS";

	public static final String UPI_QR_CODE = "UPI_QR_CODE";

	public static final String[] person = { "A", "B", "C" };
	public static final Map<String, String> QR_TYPELIST = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(DYNAMIC_QR_CODE, "DYNAMIC_QR_CODE_HEADER");
			put(MERCHANT_QR_CODE, "MERCHANT_QR_CODE_HEADER");
			put(QR_ORDER, "QR_ORDER_HEADER");
//			put(QR_PRODUCT, QR_PRODUCT_HEADER);
			put(USER_QR_CODE, "USER_QR_CODE_HEADER");
			put(GENERATE_QR_IMG, "GENERATE_QR_IMG_HEADER");
			put(QR_CODE_DEEPLINK, "QR_CODE_DEEPLINK_HEADER");
			put(QR_PRICEDPRODUCT, "QR_PRICEDPRODUCT_HEADER");
			put(UPI_QR_CODE, "UPI_QR_CODE_HEADER");
			put(UTS, "UTS_HEADER");
		}

	};
}