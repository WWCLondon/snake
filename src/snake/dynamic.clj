(ns snake.dynamic
  (:require [quil.core :as q]))

(def red 1)
(def orange 25)
(def yellow 50)
(def green 100)
(def blue 150)
(def purple 200)

(def window-size 800)
(def grid-size 10)
(def cell-size (/ window-size grid-size))

(def snake (atom nil))

(defn reset-snake []
  (reset! snake
          [[0 0]
           [0 1]
           [0 2]]))

(reset-snake)

(defn +mod [x y]
  (mod (+ x y) grid-size))

(defn vec+ [[x1 y1]
            [x2 y2]]
  [(+mod x1 x2) (+mod y1 y2)])

(def up [0 -1])
(def down [0 1])
(def left [-1 0])
(def right [1 0])

(defn update-snake [snake direction]
  (conj (rest snake)
        (vec+ (last snake))))

(defn move [snake direction]
  (swap! snake #(update-snake % direction)))

(defn draw-cell [[x y] hue]
  (q/fill (q/color hue 255 255))
  (q/rect (* cell-size x) (* cell-size y) cell-size cell-size))

(defn setup []
  (q/smooth)
  (q/color-mode :hsb)
  (q/frame-rate 1))

(reset-snake)
(move snake down)


(defn draw []
  (q/background 0)
  (dosync
   (doseq [cell @snake]
     (draw-cell cell red))))
