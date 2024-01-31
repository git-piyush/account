package com.example.demo;


public class Annotation {

	
	//@PathVariable vs @RequestParam Annotations
/*	@GetMapping(path = "/hello-world/{id}/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable long id, 
        @PathVariable(name = "name") String name) {
        return new HelloWorldBean(id, name);
    }
	
	
    @GetMapping(path = "/hello-world")
    public HelloWorldBean helloWorldPathVariable(@RequestParam long id, 
        @RequestParam String name) {
        return new HelloWorldBean(id, name);
    }
    */
	
	//@ModelAttribute annotation
	/*
	 * The @ModelAttribute annotation is one of the most important annotations in
	 * Spring MVC. It binds a method parameter or a method return value to a named
	 * model attribute and then exposes it to a web view.
	 * 
	 * @ModelAttribute can be used either as a method parameter or at the method level.
	 * 
	 * 
	 * 
	 * When the annotation is used at the method level it indicates the purpose of that method is to add one or more model attributes.
		@ModelAttribute
		public void addAttributes(Model model) {
    	model.addAttribute("msg", "Hello World");
			}
			
			
	    As a Method Argument
		When used as a method argument, it indicates the argument should be retrieved from the model.

		For example, the employee form data will be bound to Employee bean using @ModelAttribute annotation:
		
		@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
		public String submit(@ModelAttribute("employee") Employee employee) {
		    // Code that uses the employee object
		
		    return "employeeView";
		}
		
		
	 */
	
	
	
	
	
}
