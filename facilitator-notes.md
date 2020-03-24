Two files are provided to guide students through common tasks with the ArrayList and HashMap

## Prep

1. Review the code provided
1. Delete all code underneath comments - leave the comments
1. Remove all unnecessary import statements

## During the clinic

1. Introduce the exercise - share how we'll be working through the code together
1. Start with ArrayDrills 
1. Point out how we can load assets (like the provided text files) in a Maven project (this code is provided and should stay in the files)

     - `class` is very meta - it's used to reference the existence of the class.
     - Remember that in Java as much as possible, everything is an object
     - Even our class definitions are objects
     - The `class` keyword allows us to reflect or introspect on our `class` definition
     - With `getResource`, Java will search system resources and all "resources" directories in the class path for the provided name
     - More detail of `getResource`: <https://docs.oracle.com/javase/8/docs/technotes/guides/lang/resources.html>
  
2. Reference JavaDoc where possible to show how you reference the docs to determine how to solve the problem
3. Work with the students to implement each of the tasks

## Specifics

1. Be sure to program to an interface - assign variables of types `List`, `Set`, and `Map`
1. Close your scanners
1. In the last task in ArrayDrills, we're called to use `compareTo` - pull up the compareTo docs and define "lexagraphical ordering" (alphabetical order)
1. When we build the initial HashMap, point out how `split` does not return an `ArrayList` - it returns a `String[]` because the length of the Array is known and effectively static