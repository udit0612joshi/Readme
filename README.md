# Manhattan Presto

Presto is an open source distributed SQL query engine for running interactive analytic queries against data sources of all sizes ranging from gigabytes to petabytes.Presto allows querying data where it lives, including Hive, Cassandra, relational databases or even proprietary data stores. A single Presto query can combine data from multiple sources, allowing for analytics across your entire organization.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


## Installing

End with an example of getting some data out of the system or using it for a little demo

### To build the image for dbr presto
```
docker build -t dbr/presto .
```
### To push the image to docker hub
```
docker push dbr/presto:v1
```
### To run the container that accepts connection from outside
```
docker run -p 8443:8443 --name presto -d dbr/presto --link postgres
```

### To login into container
```
docker exec -it presto bash
```
## Examples

### Execute sql on presto using ODBC driver
isql PRESTODS
```
select * from accounts
```
### Execute sql on presto using JDBC driver
```
/opt/teradata/presto_clients/presto --server localhost:9090 --catalog postgresql --schema public --execute 'SHOW SCHEMAS FROM postgresql;'
```
### Execute sql on presto using ODBC driver on ssl
```
isql PRESTODSSSL
select * from accounts
```

## Running the tests

This will show  how to run the automated tests for this system


###To run postgresql_connector group use the mentioned command 

```
presto-product-tests/bin/run.sh singlenode -g postgresql_connector --conf presto-product-tests/target/classes/tempto-configuration.yaml

```



###Running Presto with Hive

```
presto-product-tests/bin/run.sh singlenode -g hive_coercion,hive_connector,post_hive_1_0_1,basic_sql -x authorization,profile_specific_tests --conf presto-product-tests/target/classes/tempto-configuration.yaml

```

## Deployment

./gradlew composeUp


## Contributing

Please read [CONTRIBUTING.md](https://github.com/dbresearchinc/manhattan.git) for details on our code of conduct, and the process for submitting pull requests to us.


## License

This project is licensed under the MIT License - see the [LICENSE.md]  file for details

## Acknowledgments

https://prestodb.io/
