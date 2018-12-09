# foodtruck-finder

This application will take in the food truck data from the San Francisco government’s API(https://data.sfgov.org/Economy-and-Community/Mobile-Food-Schedule/jjew-r69b) in order to find food trucks that are open when you run the application.

The constraints of the application are that the food trucks must be open, and it should return names and addresses in pages of 10. Rather than querying for everything and then filtering in java, I made use of the SODA query parameters available on the San Fransisco API. By restricting my search and pagination there, It's not only more performant, but has a smaller rest payload coming back.
I designed this to use domain driven design principles, so it uses Repositories to retrieve domain related entities, and factories in order to build them.

In order to run the application, download and then change to the directory in your command line and run:

```
mvn package shade:shade
java -jar ./target/com.foodtruck.finder-0.0.1-SNAPSHOT.jar
```
