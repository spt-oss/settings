# SPT Java Settings

[![circleci](https://img.shields.io/badge/circleci-spt--java--settings-brightgreen.svg)](https://circleci.com/gh/spt-oss/spt-java-settings)
[![maven central](https://img.shields.io/badge/maven_central-spt--java--settings-blue.svg)](https://mvnrepository.com/artifact/com.github.spt-oss/spt-java-settings)

* Java settings for SPT projects
* Checkstyle, Eclipse, etc.

## Usage

### Eclipse

* Clone the repository and import the settings into your Eclipse.

	```bash
	src/main/resources/
	    spt/
	        settings/
	            checkstyle/
	                checkstyle.xml # For Checkstyle
	            eclipse/
	                platform/      # For Eclipse platform
	                project/       # For Eclipse projects
	```

### Maven

* Add a dependency in your POM.

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

* This software is released under the Apache License 2.0.
