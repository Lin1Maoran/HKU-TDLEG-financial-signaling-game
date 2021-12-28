(ns financial-signaling-game.core)

;; Welcome to the world of signaling game!
(let [x "Lynn"]
(println x ", weclome to the world of signaling game!"))

;; Probability of a Successful Investment Project
(defn exponential
  "natural exponential function"
  [n]
  (Math/exp n))

(defn dilute
  [t lamag]
  (exponential (- 0 (* lamag t))))

(def po 0.3)
(def pi (- 1 po))

(defn possible
  "the total probability of observing a successful project before t"
  [t lamag]
  (+ po (* pi (dilute t lamag))))

(defn belief
  "the beliefs of firms at t about a successfully investment"
  [t lamag]
  (/ po (possible t lamag)))

;; The Stakes of Investors
(def I 10000)
(def R 30000)
(def r 0.01)

;; Firms' Pure Strategies
(defn profit
  "The Profit of Firms"
  [x t lamag]
  (* (- 1 x) (possible t lamag) (- (* R (belief t lamag)) I)))

(defn discount
  "Firm's cost of waiting---discount their payoffs"
  [t]
  (exponential (- 0 (* r t))))

(defn payoff
  "Firms' payoff from choosing different investing time."
  [x t lamag]
  (* (discount t) (profit x t lamag)))

(defn optimal
"Firms' optimal investing time"
[lamag]
(max (- 0 (* (/ 1 lamag) (Math/log (/ (* po (* r (- R I))) (* I (* pi (+ lamag r))))))) 0))

;; Under Asymmetrical Information
(def lamago 3)
(def lamagi 5)

(defn exppossible
  "The investors expected beliefs about observing a successful investment project."
  [q t]
  (+ (* q (possible lamago t)) (* (- 1 q) (possible lamagi t))))

(defn expbelief
  "the beliefs of investors at t about a successfully investment"
  [q t]
  (/ po (exppossible q t)))

;; The investors' Stakes. In debt financing, it will be the interests of loans
(defn stake
  "The Stakes of Investors"
  [x q t]
  (* x (- (* R (expbelief q t)) I)))

;; Firms' payoff under asymmetrical information.
(defn asyprofit
  "The Profit of Firms under asymmetrical information."
  [x q t lamag]
  (* (- 1 x) (possible t lamag) (- (* R (belief t lamag)) (+ I (stake x q t)))))

(defn asypayoff
  "Firms' payoff from choosing different investing time."
 [x q t lamag]
  (* (discount t) (asyprofit x q t lamag)))

(defn -main 
  "Firms' optimal investing time"
  [lamag] 
  (println (optimal (Integer/parseInt lamag))))

