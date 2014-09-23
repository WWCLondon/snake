(ns snake.core
  (:require [quil.core :as q]))

(def red 1)
(def orange 25)
(def yellow 50)
(def green 100)
(def blue 150)
(def purple 200)

(def window-size 200)
(def grid-size 10)
(def cell-size (/ window-size grid-size))
(def snake { :color blue
             :bodyparts [[3 2 ][2 2][1 2]]
            })

(defn draw-cell [[x y] hue]
  (q/fill (q/color hue 255 255))
  (q/rect (* cell-size x) (* cell-size y) cell-size cell-size))

(defn setup []
  (q/smooth)
  (q/color-mode :hsb)
  (q/frame-rate 1))


;(def v1 [1 3])

;(def v2 [3 4])


;(defn vec+ [[x1 y1] [x2 y2]]
;  [(+ x1 x2) (+ y1 y2)])

(defn draw []
  (q/background 0)



  (let [color (snake :color)]
    (doseq [x (snake :bodyparts)]
      (draw-cell x color )))

  ;; Add stuff here
  )

(q/defsketch snake-game
  :title "Snake"
  :setup setup
  :draw draw
  :size [window-size window-size]
  )

(defn -main [])
