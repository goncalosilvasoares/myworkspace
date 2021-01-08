# URL Shortster

## General info
This project is one URL Shortster.

* A user can submit a URL and receive a unique shortcode in response.
* A user can submit a URL and shortcode and will receive the chosen shortcode if it is available.
* A user can access a shortcode and be redirected to the URL associated with that shortcode, if it exists.
* All shortcodes can contain digits, upper case letters, and lowercase letters. It is case sensitive.
* Automatically generated shortcodes are exactly 6 characters long.
* User submitted shortcodes must be at least 4 characters long.
* A user can access a shortcode stats endpoint in order to see when the shortcode was registered, when it was last accessed, and how many times it was accessed.
* A user can delete the URL.

## Technologies
This project was created with:
```
* MySQL.
* Java.
* JavaScript.
* HTML.
* CSS.
* Spring.
* REST API.
* Hibernate.
* Mockito.
```
## Tools
```
* Intellij.
* Visual Studio Code.
* MySQL.
* POSTMAN.
* Apache Tomcat.
```
## Setup
To run this project:
```
* Install Tomcat.
* Install MySQL.
```
* Verify if tomcat < server > name in pom.xml file in last plugin is the same.
* Create database with name "urlShortster".
* Change the file "resources/urlShortster.properties" properties to the same in the MySQL Database access.

Run this commands on IDE:

```
$ mvn install
$ mvn tomcat7:deploy
```
* Open file Index.html and use the WebApp.
## Enjoy