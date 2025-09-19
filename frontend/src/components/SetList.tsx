import React from "react";
import SetCard from "./SetCard";
import { buildUrl } from "../api";
import type { LegoSet } from "../types";

function buildQuery(params: Record<string, any>) {
    const q = new URLSearchParams();
    Object.entries(params).forEach(([k, v]) => {
        if (v !== undefined && v !== null) q.append(k, String(v));
    });
    const qs = q.toString();
    return qs ? `?${qs}` : "";
}

export default function SetList({ filters }: { filters: Record<string, any> }) {
    const [sets, setSets] = React.useState<LegoSet[]>([]);
    const [loading, setLoading] = React.useState(false);
    const [error, setError] = React.useState<string | null>(null);

    React.useEffect(() => {
        setLoading(true);
        setError(null);
        const url = buildUrl(`/api/v1/set${buildQuery(filters)}`);
        fetch(url)
            .then((r) => {
                if (!r.ok) throw new Error(`Status ${r.status}`);
                return r.json();
            })
            .then((data) => setSets(data))
            .catch((err) => setError(err.message))
            .finally(() => setLoading(false));
    }, [filters]);

    if (loading) return <div>Loading…</div>;
    if (error) return <div style={{ color: "red" }}>Error: {error}</div>;
    if (!sets.length) return <div>No sets found</div>;

    return (
        <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fit, minmax(260px, 1fr))", gap: 12 }}>
            {sets.map((s) => (
                <SetCard key={s.name} set={s} />
            ))}
        </div>
    );
}
