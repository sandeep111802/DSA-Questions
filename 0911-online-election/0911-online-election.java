class TopVotedCandidate {

    int[] times;
    int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;

        this.times = times;
        leaders = new int[n];

        Map<Integer, Integer> count = new HashMap<>();

        int leader = -1;
        int maxVotes = 0;

        for (int i = 0; i < n; i++) {
            int p = persons[i];

            count.put(p, count.getOrDefault(p, 0) + 1);

            if (count.get(p) >= maxVotes) {
                maxVotes = count.get(p);
                leader = p;
            }

            leaders[i] = leader;
        }
    }

    public int q(int t) {
        int l = 0;
        int r = times.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (times[mid] <= t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return leaders[r];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */