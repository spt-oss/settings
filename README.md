# SPT Java Settings [![CircleCI](https://circleci.com/gh/spt-oss/spt-java-settings.svg?style=svg&circle-token=833a5ace2d3bd1ca42536b456ba46d17e341dd76)](https://circleci.com/gh/spt-oss/spt-java-settings)

* Java settings for SPT projects: Checkstyle, Eclipse, etc.

## Usage

### Use in Eclipse

* Clone the repository and import the settings into your Eclipse.

	```bash
	src/main/resources/
	    spt/
	        settings/
	            checkstyle/
	                checkstyle.xml # Checkstyle
	            eclipse/
	                platform/      # Eclipse platform
	                project/       # Eclipse projects
	```

### Use in Maven

* Add the dependency in your POM ( [Maven Central](https://repo1.maven.org/maven2/com/github/spt-oss/spt-java-settings/) ).

	```xml
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-checkstyle-plugin</artifactId>
		<configuration>
			<configLocation>spt/settings/checkstyle/checkstyle.xml</configLocation>
		</configuration>
		<dependencies>
			<dependency>
				<groupId>com.puppycrawl.tools</groupId>
				<artifactId>checkstyle</artifactId>
				<version>X.X.X</version>
			</dependency>
			<dependency>
				<groupId>com.github.spt-oss</groupId>
				<artifactId>spt-java-settings</artifactId>
				<version>X.X.X</version>
			</dependency>
		</dependencies>
	</plugin>
	```

## License

This software is released under the Apache License 2.0.
