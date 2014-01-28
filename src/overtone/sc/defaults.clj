(ns overtone.sc.defaults
  (:use [overtone.helpers.file :only [dir-exists?]]
        [overtone.helpers.lib :only [windows-sc-path]])
  (:require [overtone.at-at :as at-at]))

(def empty-foundation-groups {:overtone-group          nil
                              :input-group             nil
                              :root-group              nil
                              :user-group              nil
                              :safe-pre-default-group  nil
                              :default-group           nil
                              :safe-post-default-group nil
                              :mixer-group             nil
                              :monitor-group           nil})

(defonce foundation-groups* (atom empty-foundation-groups))

(def DEFAULT-MASTER-VOLUME
  "Initial value for the master volume of the mixer"
  0.8)

(def DEFAULT-MASTER-GAIN
  "Initial value for the master gain of the mixer"
  1)

(def DEFAULT-VOICE-VOLUME
  "Initial value for the volume of a voice"
  1.0)

(def DEFAULT-VOICE-PAN
  "Initial value for the pan of a voice (center)"
  0.0)

(def SERVER-PORT
  "Default port number used when booting external server. If nil, a random port is used"
  nil)

(def N-RETRIES
  "Number of times to attempt to connect to an externally booted server"
  50)

(def REPLY-TIMEOUT
  "Max number of milliseconds to wait for a reply from the server"
  500)

(def MAX-OSC-SAMPLES
  "Max number of samples supported in a UDP OSC message. Obtained
  through experimentation."
  1838)

(def INTERNAL-POOL
  "make an at-at pool for all internal scheduling"
  (at-at/mk-pool))

(def SC-PATHS
  "Default system paths to an externally installed SuperCollider server for
  various operating systems."
  {:linux ["scsynth"]
   :windows [(str (windows-sc-path) "\\scsynth.exe")]
   :mac  ["/Applications/SuperCollider/scsynth"
          "/Applications/SuperCollider.app/Contents/Resources/scsynth"
          "/Applications/SuperCollider/SuperCollider.app/Contents/Resources/scsynth"]})

(def SC-OS-SPECIFIC-ARGS
  "Extra arguments required to correctly boot an external SuperCollider
  server for various operating systems."
  {:linux   {}
   :windows {}
   :mac     {:ugens-paths  ["~/Library/Application Support/SuperCollider/Extensions/SC3plugins"
                            "/Library/Application Support/SuperCollider/Extensions/SC3plugins"
                            "/Applications/SuperCollider/plugins"
                            "/Applications/SuperCollider.app/Contents/Resources/plugins"
                            "/Applications/SuperCollider/SuperCollider.app/Contents/Resources/plugins"]}})

(def SC-MAX-FLOAT-VAL (Math/pow 2 24))
