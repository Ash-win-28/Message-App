package com.ashwin.message_app.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "folders_by_user")
@Getter
@Setter
@AllArgsConstructor
public class Folders {

    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String userId;

    @PrimaryKeyColumn(name = "label", type = PrimaryKeyType.CLUSTERED, ordinal = 1)
    private String label;

    @CassandraType(type = CassandraType.Name.TEXT)
    private String color;

}
