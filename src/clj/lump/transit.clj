(ns lump.transit
  (:import [java.io ByteArrayOutputStream])
  (:require [cognitect.transit :as transit]))

(defn write [x]
  (let [baos (ByteArrayOutputStream.)
        w    (transit/writer baos :json)
        _    (transit/write w x)
        ret  (.toString baos)]
    (.reset baos)
    ret))

(defn writev [x]
  (let [baos (ByteArrayOutputStream.)
        wv   (transit/writer baos :json-verbose)
        _    (transit/write wv x)
        ret  (.toString baos)]
    (.reset baos)
    ret))
