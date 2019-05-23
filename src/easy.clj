(ns easy)

;; #19 Last Element
(fn [a] (first (reverse a)))

;; #20 Penultimate Element

(fn [a]
  (first
    (rest
      (reverse a)
      )
    )
  )

;; #21 Nth Element

(fn [a b] (first ( drop b a )))

;; #22 Count a Sequence

(fn [input]
  (loop [a input
         out 0]
    (if (empty? a)
      out
      (recur (rest a) (inc out)))))

;; #23 Reverse a Sequence

(fn my-reverse [a]
  (when (not (empty? a))
    (cons (last a) (my-reverse (butlast a))))
  )

;; #24 Sum It All Up

(fn [a] (reduce + a))

;; #25 Find the odd numbers

(fn [a] (filter odd? a))

;; #26 Fibonacci Sequence

(fn [ptake]
  (take ptake((fn fib [a b]
                (lazy-seq (cons a (fib b (+ a b)))))
               1 1)))

;; #27 Palindrome Detector

(fn pal [a]
  (if (or (nil? a) (empty? a) (= (count a) 1 ) )
    true
    (and (= (first a) (last a)) (pal (rest (butlast a)))) ))

;; #28 Flatten a Sequence

#(filter (complement sequential?) (tree-seq sequential? identity %))


;; #29 Get the Caps
(fn [a] (apply str (filter #(Character/isUpperCase %) a)))

;; #30 Compress a Sequence

(fn [in] (map first (partition-by identity in)))

;; #31 Pack a Sequence

(fn [in] (partition-by identity in) )

;; #32 Duplicate a Sequence

(fn [in] (mapcat
           (fn [a] (list a  a))  in ))

;; #33 Replicate a Sequence

(fn [in n] (mapcat
              (fn [a] (repeat n a ))  in ))

;; # 34 Implement range

(fn [a b] (take (- b a)  (iterate inc a)))

;; #38 Maximum value

(fn [& args] (first (sort > (mapcat (fn [a] (list (identity a))) args))))


;; #39 Interleave Two Seqs

(fn [in1 in2]
    (mapcat (fn [a b] (list a b))
            in1 in2
            )
    )

;; # 40 Interpose a Seq

(fn [del ins]
    (cons
      (first ins)
      (mapcat (fn [a] (list del a)) (rest ins) )
      )
    )