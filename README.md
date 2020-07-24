# Software-Application-floor
**This software application helps with floor layout** 
Following operations can be possible:

Add a floor plan: 

a. User enters a coordinate pairs: (x1, y1), (x2, y2), (x3,y3), (x4, y4)...

b. Application validates the input  

Assumptions:  

1. Adjacent Room walls form right angles.
2. Corners lie on a Cartesian grid. 
3. At least 4 corners must be present. 

Validations:    

1. Coordinates are integers. 
2. Only positive numbers from 0 to 9 
3. Walls do not intersect  
4. No diagonal walls. 
5. Room has a finite area. 

Examples:   

(1,1), (2,2) -> illegal, as it would result in the wall going diagonally. Illegal, as at least 4 corners must be present. 

(1,1), (1,2), (2,2), (2,1) -> Legal. It is a square.  

(1,1), (1,2,),(0,2),(0,3),(2,3),(2,1) -> Legal, the floor of the room can be of any shape if all conditions are met.
