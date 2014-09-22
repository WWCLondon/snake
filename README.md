# snake

This is a basic project set up to use Quil for drawing, you can call `(draw-cell [x y] hue)` (eg `(draw-cell [1 1] red)` to fill the cell with the color you want.

Quil runs `setup` once and runs `draw` with every frame (1 times a second in the initial code, but feel free to change it)

We are going to try and build the famous 'snake' game

## Tasks

# Colour in some cells
Get a feel for drawing by updateing the `draw` function, you may want to use `doseq` for looping over a list of things and doing side-effects.

# Draw a snake and have it move to the right
You will need to choose an appropriate representation for the game world.
You can use the `draw` function as the 'tick' in the world and have it update the snakes position and draw the appropriate cells with every tick.

# Make the snake move 50 R 50D 50L 50U

# Questions
## What happens at the edges of the drawing?
## Can you move left if you are heading right?
## What is the best gridsize and framerate for the game?

# Take input
Add `:key-typed key-pressed` to `q/defsketch` and create a function called `key-pressed` that will get called with every keypress.
Start off using normal keys (the arrow keys are tricky)
```
(defn key-pressed []
  (let [key (q/raw-key)] ; note key is a char (ie \w or whatever)
    (println key)
    ; You should do something else here
    ))
```

# Add food
Food should appear at one point and your snake should grow if it eats it, more should appear at a random point when some is eaten

# Battle snake
Try and go head to head with another player

# Networked battle snake
Run a server and let people connect as clients

## Usage

lein run wull run snake.core (the -main fn is empty as defsketch starts Quil Running)

## License

Copyright © 2014 thattommyhall

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
