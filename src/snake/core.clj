(ns snake.core
  (:require [quil.core :as q]
            [snake.dynamic :as dynamic :refer [window-size]]))

(q/defsketch snake
  :title "Snake"
  :setup dynamic/setup
  :draw dynamic/draw
  :size [window-size window-size])
