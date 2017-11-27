
# Manhattan Postgressql

PostgreSQL (pronounced as post-gress-Q-L) is an open source relational database management system (DBMS) developed by a worldwide team of volunteers. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


## Installing

### To build the image for dbr presto
```
 ../gradlew build
```


## Deployment
```
./gradlew composeUp
```

## Connection with psql
```
 psql -h localhost -U dbr -p 5432 -d dbrdb

```

## Contributing

Please read [CONTRIBUTING.md](https://github.com/dbresearchinc/manhattan.git) for details on our code of conduct, and the process for submitting pull requests to us.


## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/dbresearchinc/manhattan/blob/master/manhattan_dev/LICENSE)  file for details

## Acknowledgments

https://www.postgresql.org/docs/

