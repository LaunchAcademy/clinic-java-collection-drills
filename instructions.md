Two files are provided to guide you through common tasks with the ArrayList and HashMap

## Prep
1. checkout `starter-code branch`

## During the clinic

1. Start with ArrayDrills 
2. We can load assets (like the provided text files) in a Maven project (this code is provided and should stay in the files) using the resources root
     - `class` is very meta - it's used to reference the existence of the class.
     - With `getResource`, Java will search system resources and all "resources" directories in the class path for the provided name
     - More detail of `getResource`: <https://docs.oracle.com/javase/8/docs/technotes/guides/lang/resources.html>
  
## Specifics

1. Be sure to program to an interface - assign variables of types `List`, `Set`, and `Map`
1. Close your scanners
1. In the last task in ArrayDrills, we're called to use `compareTo` - pull up the compareTo docs and define "lexagraphical ordering" (alphabetical order)
1. When we build the initial HashMap, point out how `split` does not return an `ArrayList` - it returns a `String[]` because the length of the Array is known and effectively static