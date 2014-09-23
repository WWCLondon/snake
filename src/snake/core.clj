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

(defn draw-cell [[x y] hue]
  (q/fill (q/color hue 255 255))
  (q/rect (* cell-size x) (* cell-size y) cell-size cell-size))

(defn setup []
  (q/smooth)
  (q/color-mode :hsb)
  (q/frame-rate 1))

(defn draw []
  (q/background 0)
  (draw-cell [1 2] red)
  (draw-cell [1 3] red)
  ; Add stuff here
  )

(q/defsketch snake-game
  :title "Snake"
  :setup setup
  :draw draw
  :size [window-size window-size]
  )

(defn -main [])
