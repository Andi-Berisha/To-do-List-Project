Coverage: 96.2%
![test coverage](https://github.com/AndiberishQA/To-do-List-Project/blob/main/Project%20Documentation/testCoverage.JPG)


# To-Do List Web Application Project
This project involved the design and creation of to-do list web application. The project has full crud functionality and allows user to make an account and create 
a to do list for their everyday lives.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
You will need the following softwares to run this application and all of its tests:

Java: https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html

Spring Tool Suite 4:  https://spring.io/tools

Git Bash:  https://git-scm.com/download/win

Maven: https://maven.apache.org/index.html


### Installing
1. Fork and then clone down this repo to your system.
2. Open your Spring Tool Suite 4.
3. Open the project by clicking on file > open projects from file system.
4. Go to local on the boot dashboard and select the project.
5. Click Start Process.

To run the application from the command line, write the following command:

```
$java -jar ToDo_Project-0.0.1-SNAPSHOT.jar 
```

## Running the tests
To run the tests and view test coverage % for each class, right click on the project in spring
and select coverage as, then select JUnit Test.

### Unit Tests 
Unit testing is a testing approach that targets the very fundamental building blocks of an application, the idea is to prove 
that each 'unit' of the application is functioning as expected. Moreover, Unit testing is an automated process, which is designed to be reusable and provide reliable results.
Lastly, the idea of unit testing is to ensure that our unit functions in isolation, this means we want to check that the performed actions of that unit/class meet our expectations.

* **Unit Testing Example:**
```
	@Test
	public void create() {
		// Resources employed
		TaskDomain exampleTask = new TaskDomain(1L, "Laundry", true, null);
		TaskDTO exampleDTO = new TaskDTO(1L,"Laundry", true);

		// Rules set
		Mockito.when(this.mockedRepo.save(Mockito.any(TaskDomain.class))).thenReturn(exampleTask);
		Mockito.when(this.mapper.map(exampleTask, TaskDTO.class)).thenReturn(exampleDTO);

		// Actions performed
		TaskDTO result = this.service.create(exampleTask);

		// Assertions made
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(exampleDTO);
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(exampleDTO);

		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(TaskDomain.class));
		Mockito.verify(this.mapper, Mockito.times(1)).map(exampleTask, TaskDTO.class);

	}

```
### Integration Tests 
Integration testing is a testing approach that targets the very fundamental building blocks of an application,
the idea is to prove that each 'integration' of the application is functioning as expected.

* **Integration Test Example:**
```
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema-test.sql","classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles="test")
class UserControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	private final int ID = 4;
	
	
	List<TaskDomain> tasksDomain = new ArrayList<>();
	List<TaskDTO> tasks = new ArrayList<>();
	
	private UserDTO mapToDTO(UserDomain model) {
		return this.mapper.map(model, UserDTO.class); 
	}
	
	
	
	
	@Test
	public void read() throws Exception{
		
		
		UserDTO expectedOutcome = new UserDTO(4L, "John", "Behar",tasks);
		// Set up the request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.GET, "http://localhost:8081/user/read/" + ID);
		
	// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(jsonifier.writeValueAsString(expectedOutcome));
		
	//Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
}

```

## Deployment
1. Go to project folder and open cmd line.
2. Type: mvn clean package
3. cd into the target folder of the project
4. then type $java -jar ToDo_Project-0.0.1-SNAPSHOT.jar 
5. Access the front end by going to http://127.0.0.1:8081/HTML/Andi/Index.html





## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Andi Berisha** 

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments
* **Savannah**
* **Alan Davis**


