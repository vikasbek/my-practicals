package com.paytm.springbootcassandra.config;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {
	@Value("${cassandra.keyspace}")
	private String KEYSPACE;

	@Value("${cassandra.basePackages}")
	private String basePackages;

	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		CreateKeyspaceSpecification specification =
				CreateKeyspaceSpecification.createKeyspace(KEYSPACE).ifNotExists().with(KeyspaceOption.DURABLE_WRITES, true).withSimpleReplication(3);
		return Arrays.asList(specification);
	}


	@Override
	protected String getKeyspaceName() {
		return KEYSPACE;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}
}
