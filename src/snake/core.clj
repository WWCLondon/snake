(ns snake.core
  (:require [quil.core :as q]))

(defn setup []
  (q/smooth)
  (q/color-mode :hsb)
  (q/frame-rate 1))

(def red 1)
(def orange 25)
(def yellow 50)
(def green 100)
(def blue 150)
(def purple 200)

(def window-size 800)
(def grid-size 100)
(def cell-size (/ window-size grid-size))

(def grid {[1 1] red
           [2 2] orange
           [3 3] yellow
           [4 4] green
           [5 5] red})

(defn draw-cell [[x y] hue]
  (q/fill (q/color hue 255 255))
  (q/rect (* cell-size x) (* cell-size y) cell-size cell-size))

(defn draw []
  (q/background 0)
  (dosync
   (doseq [[cell hue] grid]
     (draw-cell cell hue))))

(q/defsketch snake
  :title "Snake"
  :setup setup
  :draw draw
  :size [window-size window-size])
