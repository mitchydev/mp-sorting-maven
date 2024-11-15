# mp-sorting-maven

An exploration of sorting in Java.

Authors

* Mitchell Paiva
* Samuel A. Rebelsky (starter code)

Acknowledgements

* I used ChatGPT by Openai for Part 3 and in PaivaMitchSort.java as allowed in the course instructions.
* I worked with Sheilla Mulligande on this Mini Project, disucssing core ideas and concepts needed to takle each question/part of the MP.

This code may be found at <https://github.com/mitchydev/mp-sorting-maven>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-sorting-maven>.

Description of custom sorting algorithm
---------------------------------------

My custom sorting algorithm is a hybrid between merge sort and insertion sort. It uses the divide and conquer strategy of merge sort with the efficiency of an insertion sort. For large subarrays, we use merge sort, and for small subarrays we use insertion sort, which maximizes efficiency.

Notes on using Copilot (or other AI)
------------------------------------

I used ChatGPT by OpenAI on part 3, as allowed by the course instructions, and I found that it helped shape my original idea and starter code (which turned out to be wrong) into viable code. Using this tool helped me understand how sorting algorithms can be efficient and what makes them efficient. It was also convienient having it clarify how certain aspects of this algorithm worked if I wasn't specifically understanding something.
