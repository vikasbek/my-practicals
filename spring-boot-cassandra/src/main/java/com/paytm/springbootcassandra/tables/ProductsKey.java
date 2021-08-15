package com.paytm.springbootcassandra.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import com.datastax.driver.core.DataType;

@PrimaryKeyClass
public class ProductsKey implements Serializable {
	private static final long serialVersionUID = 7731243598363616828L;


	@PrimaryKeyColumn(name = "productName", type = PrimaryKeyType.PARTITIONED)
	private String productName;

	@PrimaryKeyColumn(name = "price", ordinal = 0)
	private BigDecimal price;

	@PrimaryKeyColumn(name = "id", ordinal = 1, ordering = Ordering.DESCENDING)
	@CassandraType(type = DataType.Name.UUID)
	private UUID id;

	public ProductsKey() {
		this.id = UUID.randomUUID();
	}

	public ProductsKey(final String productName, final BigDecimal price) {
		this.productName = productName;
		this.id = UUID.randomUUID();
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductsKey [productName=" + productName + ", price=" + price + ", id=" + id + "]";
	}


}
