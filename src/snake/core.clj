(ns snake.core
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

(def up [0 -1])
(def down [0 1])
(def left [-1 0])
(def right [1 0])
(def direction (atom up))


(defn draw-cell [[x y] hue]
  (q/fill (q/color hue 255 255))
  (q/rect (* cell-size x) (* cell-size y) cell-size cell-size))

(defn setup []
  (q/smooth)
  (q/color-mode :hsb)
  (q/frame-rate 1))

(defn draw []
  (q/background 0)
  (move snake @direction)
  (dosync
   (doseq [cell @snake]
     (draw-cell cell red))))


(q/defsketch snake-game
  :title "Snake"
  :setup setup
  :draw draw
  :size [window-size window-size]
  :key-typed key-pressed)

(defn -main [])
