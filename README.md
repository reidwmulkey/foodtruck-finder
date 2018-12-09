# foodtruck-finder

This application will take in the food truck data from the San Francisco government’s API(https://data.sfgov.org/Economy-and-Community/Mobile-Food-Schedule/jjew-r69b) in order to find food trucks that are open when you run the application.

The constraints of the application are that the food trucks must be open, and it should return names and addresses in pages of 10. Rather than querying for everything and then filtering in java, I made use of the query parameters available on the San Fransisco API. By restricting my search and performing pagination there, It's more performant and has a smaller json payload coming back. 

I designed this to use domain driven design principles, so it uses repositories to retrieve domain related entities, and factories in order to build them. Most of the magic happens in `FoodTruckRepository.java`, and then the printing logic happens in `FoodTrucks.java`.

If I were to bring this application up to a production environment for a REST API, I feel like the only way to speed up retrieval of the food truck data would be to implement a cache. The REST response would also be more focused on mapping the domain entity to a response object, rather than the printing logic for the CLI right now. I would also likely add more fields to `FoodTruck.java` and `FoodTruckResponse.java` because they are quite barebones right now.

In order to run the application, download and then change to the directory in your command line and run the following command. This will install dependencies and run the jar.

```
mvn package shade:shade
java -jar ./target/com.foodtruck.finder-0.0.1-SNAPSHOT.jar
```
